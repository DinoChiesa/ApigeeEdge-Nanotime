// Nanotime.java
//
// This is the source code for a Java callout for Apigee Edge.
// This callout is very simple - it grabs the System.nanoTime() and
// inserts it into a context variable.
//
// ------------------------------------------------------------------

package com.dinochiesa.edgecallouts;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.apigee.flow.execution.ExecutionResult;
import com.apigee.flow.execution.spi.Execution;
import com.apigee.flow.message.MessageContext;
import com.apigee.flow.execution.ExecutionContext;

public class Nanotime implements Execution {
    private final static String varprefix= "nano_";
    private static String varName(String s) { return varprefix + s;}

    public Nanotime() { }

    public ExecutionResult execute (final MessageContext msgCtxt,
                                    final ExecutionContext execContext) {
        try {
            long nano = System.nanoTime();
            // set a variable.
            msgCtxt.setVariable(varName("time"), Long.toString(nano));
            return ExecutionResult.SUCCESS;

        }
        catch (java.lang.Exception exc1) {
            msgCtxt.setVariable(varName("error"), exc1.getMessage());
            msgCtxt.setVariable(varName("stacktrace"), ExceptionUtils.getStackTrace(exc1));
            // The following would go to stdout of Message processor
            // System.out.println("Exception:" + exc1.toString());
            // exc1.printStackTrace();
            return ExecutionResult.ABORT;
        }
    }
}
