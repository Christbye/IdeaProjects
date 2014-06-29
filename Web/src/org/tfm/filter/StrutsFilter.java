package org.tfm.filter;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class StrutsFilter extends StrutsPrepareAndExecuteFilter {
}

