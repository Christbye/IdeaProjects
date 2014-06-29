package org.tfm.struts;

import org.springframework.beans.factory.annotation.Autowired;
import org.tfm.service.FileService;


public class FileBaseActionSupport {
    @Autowired
    protected FileService service;
}
