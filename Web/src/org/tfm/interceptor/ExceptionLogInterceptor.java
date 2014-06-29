package org.tfm.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.springframework.dao.DataAccessException;

/**
 * Created by christ on 14-6-19.
 * Make move.
 */
public class ExceptionLogInterceptor extends AbstractInterceptor{
//    private static final Logger log = LogManager.getLogger(ExceptionLogInterceptor.class);
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        try {
            return actionInvocation.invoke();
        } catch (DataAccessException e) {
            return "error";
        } catch (Exception e) {
            e.printStackTrace();
//            log.error(actionInvocation.getInvocationContext().getName(), e);
            //TODO 非数据库的运行时异常
            return "exception";
        }
    }
}
