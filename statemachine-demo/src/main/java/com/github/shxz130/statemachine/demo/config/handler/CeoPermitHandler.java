package com.github.shxz130.statemachine.demo.config.handler;

import com.github.shxz130.statemachine.core.config.Handler;
import com.github.shxz130.statemachine.core.fire.StateMachine;
import com.github.shxz130.statemachine.core.fire.TransactionContext;
import com.github.shxz130.statemachine.demo.config.LeavePermitContextConstants;
import com.github.shxz130.statemachine.demo.config.LeavePermitEvent;
import com.github.shxz130.statemachine.demo.config.bean.LeavePermit;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jetty on 2019/7/31.
 */
@Slf4j
public class CeoPermitHandler implements Handler{

    public void handle(TransactionContext context, StateMachine stateMachine) {
        LeavePermit leavePermit=(LeavePermit)context.getData(LeavePermitContextConstants.LEAVE_PERMIT);
        leavePermit.setStatus("CEO_PERMIT");
        String ceoSuggestion=(String)context.getData(LeavePermitContextConstants.CEO_PERMIT_SUGGESTION);
        log.info("[{}],permit=[{}]", this.getClass().getSimpleName(),leavePermit);
        if(ceoSuggestion==null){
            log.info("等待ceo审批");
            return;
        }

    }

}
