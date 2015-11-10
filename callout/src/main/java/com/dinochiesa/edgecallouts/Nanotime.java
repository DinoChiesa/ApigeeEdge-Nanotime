// Nanotime.java
//
// This is the source code for a Java callout for Apigee Edge.
// This callout is very simple - it grabs the System.nanoTime() and
// inserts it into a context variable.
//
// ------------------------------------------------------------------

package com.dinochiesa.edgecallouts;

import com.apigee.flow.execution.ExecutionResult;
import com.apigee.flow.execution.spi.Execution;
import com.apigee.flow.message.MessageContext;
import com.apigee.flow.execution.ExecutionContext;

public class Nanotime implements Execution {

    public Nanotime() { }

    public ExecutionResult execute (final MessageContext msgCtxt,
                                    final ExecutionContext execContext) {
        long nano = System.nanoTime();
        // set a variable.
        msgCtxt.setVariable("nano.time", Long.toString(nano));
        return ExecutionResult.SUCCESS;
    }
}
