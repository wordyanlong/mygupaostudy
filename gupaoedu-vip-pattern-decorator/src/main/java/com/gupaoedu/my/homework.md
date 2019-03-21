1.可以使用接口实现
/**
 * 模板会有一个或者多个未现实方法，
 * 而且这几个未实现方法有固定的执行循序
 * Created by Tom.
 */
public interface NetworkCourse {

    default void createCourse() {
        //1、发布预习资料
        this.postPreResource();

        //2、制作PPT课件
        this.createPPT();

        //3、在线直播
        this.liveVideo();

        //4、提交课件、课堂笔记
        this.postNote();

        //5、提交源码
        this.postSource();

        //6、布置作业，有些课是没有作业，有些课是有作业的
        //如果有作业的话，检查作业，如果没作业，完成了
        if (needHomework()) {
            checkHomework();
        }
    }

    void checkHomework();

    //钩子方法：实现流程的微调
    boolean needHomework();

    void postSource();

    void postNote();

    void liveVideo();
    void createPPT();
    void postPreResource();
}

详见 https://github.com/wordyanlong/mygupaostudy/tree/master/gupaoedu-vip-pattern-template/src/main/java/com/gupaoedu/vip/pattern/template/course/v1


2、使用适配模式，重构一段需要升级功能且兼容老系统的业务代码。

前期实现SSO单点登录（一期统一登录平台是没有各个系统的菜单系统，需要各个系统获取主系统菜单和其他系统菜单）

原始获取代码
package io.zhongan.xdy4.ops.opsauth.service;

import com.alibaba.fastjson.JSON;
import io.zhongan.xdy4.ops.dao.mapperExt.OpsSysMenuDOMapperExt;
import io.zhongan.xdy4.ops.request.opsuser.AuthcParamsDTO;
import io.zhongan.xdy4.ops.response.opsuser.OpsAuthc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OpsAuthcService {

    @Autowired
    private OpsSysMenuDOMapperExt opsSysMenuDOMapperExt;
    /**
     *
    * @Title: getAuthcTree
    * @Description: 组装权限树
    * @param @param paramDTO
    * @param @return    设定文件
    * @return OpsAuthc    返回类型
    * @throws
     */
    public OpsAuthc getAuthcTree(AuthcParamsDTO paramDTO){
        List<OpsAuthc> hasAuthcList = null;
        //按照角色
        if(paramDTO.getRoleCode()!=null){
            hasAuthcList = getAuthcListByRoleCode(paramDTO.getRoleCode());
        }

        //按照用户
        if(paramDTO.getUsername()!=null){

            return null;
        }

        if(paramDTO.getUserNo()!=null){
            hasAuthcList = getAuthcListByUserNo(paramDTO.getUserNo());
        }

        //按照权限点
        if(paramDTO.getRootCode()!=null){
            String rootCode = paramDTO.getRootCode();
            OpsAuthc rootOpsAuthc = null;
            if("0".equals(rootCode)){
               List<OpsAuthc> menuList = opsSysMenuDOMapperExt.queryMenuDOListByParentCode(rootCode);
               if(menuList==null||menuList.isEmpty()){
                   throw new RuntimeException("组装权限树图异常，未发现根目录");
               }else if(menuList.size()>1){
                   throw new RuntimeException("组装权限树图异常，发现多条根目录:"+JSON.toJSONString(menuList));
               }else {
                   rootOpsAuthc = menuList.get(0);
               }
            }
            if(hasAuthcList!=null){
                return getAuthcTreeByRootCode(rootOpsAuthc,hasAuthcList);
            }else{
                return getAuthcTreeByRootCode(rootOpsAuthc);
            }

        }
        return null;
    }

    private OpsAuthc getAuthcTreeByRootCode(OpsAuthc authc){
        List<OpsAuthc> children = opsSysMenuDOMapperExt.queryMenuDOListByParentCode(authc.getMenuCode());
        if(children!=null&&!children.isEmpty()){
            for(OpsAuthc childAuthc:children){
                getAuthcTreeByRootCode(childAuthc);
            }
        }
        authc.setChildren(children);
        return authc;
    }


    private OpsAuthc getAuthcTreeByRootCode(OpsAuthc authc,List<OpsAuthc> authcList){
        List<OpsAuthc> children = opsSysMenuDOMapperExt.queryMenuDOListByParentCode(authc.getMenuCode());
        if(children!=null&&!children.isEmpty()){
            for(Iterator<OpsAuthc> it = children.iterator();it.hasNext();){
                OpsAuthc childAuthc = it.next();
                if(authcList!=null){
                    if(!authcList.contains(childAuthc)){
                        it.remove();
                        continue;
                    }
                }
                getAuthcTreeByRootCode(childAuthc,authcList);
            }
        }
        authc.setChildren(children);
        return authc;
    }

    public List<OpsAuthc> getAuthcListByRoleCode(String roleCode){
        return opsSysMenuDOMapperExt.queryMenuDOListByRoleCode(roleCode);
    }

    public List<OpsAuthc> getAuthcListByUserNo(String userNo){
        List<OpsAuthc> list = opsSysMenuDOMapperExt.queryMenuDOListByUserNo(userNo);
        if(list==null){
            list = new ArrayList<OpsAuthc>();
        }
        return list;
    }
}
--------------------------------------------------------------


用适配模式获取其他系统的菜单功能


package io.zhongan.xdy4.ops.opsauth.service;

import com.alibaba.fastjson.JSON;
import io.zhongan.xdy4.ops.dao.mapperExt.OpsSysMenuDOMapperExt;
import io.zhongan.xdy4.ops.request.opsuser.AuthcParamsDTO;
import io.zhongan.xdy4.ops.response.opsuser.OpsAuthc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserAuthcService {

    @Autowired
    private OpsAuthcService opsAuthcService;
    private UserAuthcMapperExt userAuthcMapperExt;
    /**
     *
    * @Title: getAuthcTree
    * @Description: 组装权限树
    * @param @param paramDTO
    * @param @return    设定文件
    * @return OpsAuthc    返回类型
    * @throws
     */
    public OpsAuthc getAuthcTree(AuthcParamsDTO paramDTO){
        return opsAuthcService.getAuthcTree(paramDTO);
    }

    public List<OpsAuthc> getAuthcListByRoleCode(String roleCode){
        return opsAuthcService.getAuthcListByRoleCode(roleCode);
    }

    public List<OpsAuthc> getAuthcListByUserNo(String userNo){
        return opsAuthcService.getAuthcListByUserNo(userNo);
    }

    /**
     * 获取USer的菜单
     * @param paramDTO
     * @return
     */
    public List<OpsAuthc> getUserAuthcTree(AuthcParamsDTO paramDTO){
        return userAuthcMapperExt.getUserAuthcTree(paramDTO);
    }

}



