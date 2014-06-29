package org.tfm.struts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tfm.entity.FMFile;
import org.tfm.entity.Kind;
import org.tfm.service.KindService;

import java.sql.SQLException;
import java.util.List;
@Controller("list-file")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ListFileAction extends FileBaseActionSupport {
    @Autowired
    private KindService kindService;

    private List<FMFile> list;
    private int kind;
    private boolean unUseJson;
    private Kind useKind;


    public void setUnUseJson(boolean unUseJson) {
        this.unUseJson = unUseJson;
    }


    public List<FMFile> getList() {
        return list;
    }
    //    public List<FMFile> getFiles() {
//        return files;
//    }


    public Kind getUseKind() {
        return useKind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String execute() throws SQLException {
        //TODO 查找所有文件是否需要
        list = service.listByKind(kind);
        useKind = kindService.getKind(kind);
        if(unUseJson)
            return "success";
        return "json";
    }

}
