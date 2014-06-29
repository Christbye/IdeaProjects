package org.tfm.struts;

import org.springframework.beans.factory.annotation.Autowired;
import org.tfm.service.AlbumService;

/**
 * Created by christ on 14-6-16.
 * Make move.
 */
public class AlbumBaseActionSupport {
    @Autowired
    protected AlbumService service;
}
