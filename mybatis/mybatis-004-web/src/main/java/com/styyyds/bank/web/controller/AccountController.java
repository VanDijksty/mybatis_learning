package com.styyyds.bank.web.controller;

import com.styyyds.bank.exception.AppException;
import com.styyyds.bank.exception.MoneyNotEnoughException;
import com.styyyds.bank.service.AccountService;
import com.styyyds.bank.service.impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 账户控制器
 * @author sty
 * @version 1.0
 * @since 1.0
 */

@WebServlet("/transfer")
public class AccountController extends HttpServlet {

    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Integer.parseInt(request.getParameter("money"));
        try{
            accountService.transfer(fromActno,toActno,money);
            out.println("<h1>转账成功！！！</h1>");
        }catch(MoneyNotEnoughException e){
            out.println(e.getMessage());
        }catch(AppException e){
            out.println(e.getMessage());
        }
    }
}
