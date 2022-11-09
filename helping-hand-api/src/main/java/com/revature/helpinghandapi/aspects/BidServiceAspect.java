//package com.revature.helpinghandapi.aspects;
//
//import com.revature.helpinghandapi.dtos.BidDTO;
//import com.revature.helpinghandapi.entities.Bid;
//import com.revature.helpinghandapi.entities.Status;
//import com.revature.helpinghandapi.repositories.BidRepository;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//import static com.revature.helpinghandapi.entities.Status.DECLINED;
//import static com.revature.helpinghandapi.entities.Status.PENDING;
//
//@Aspect
//@Component
//public class BidServiceAspect {
//    private BidRepository br;
//
//    @Pointcut("execution(public Bid com.revature.helpinghandapi.controllers.BidController.updateBid())")
//        private void updateBid(){}
//
//    @After("updateBid()")
//    public Bid afterAdvice(JoinPoint joinPoint, Status status, BidDTO bid){
//        Bid closeBid = br.findById(bid.getRequestId()).orElse(null);
//        if(bid.getBidStatus() == PENDING){
//            closeBid.setStatus(DECLINED);
//            return closeBid;
//        } else {
//            return null;
//        }
//    }
//
//}
