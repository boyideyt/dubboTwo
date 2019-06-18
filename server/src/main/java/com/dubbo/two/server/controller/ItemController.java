package com.dubbo.two.server.controller;


import com.dubbo.one.api.enums.StatusCode;
import com.dubbo.one.api.reponse.BaseResponse;
import com.dubbo.one.api.service.IDubboItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ItemController {


    private static final Logger log = LoggerFactory.getLogger(ItemController.class);

    private static final String prefix = "item";


    @Autowired
    private IDubboItemService dubboItemService;


    /**
     * 用户商城列表查询
     *
     * @return
     */
    @RequestMapping(value = prefix + "/list", method = RequestMethod.GET)
    public BaseResponse list() {
        BaseResponse response = new BaseResponse(StatusCode.Success);
        //TODO:调用服务提供方dubboOne提供的列表查询功能
        try {
            response = dubboItemService.listItems();

        } catch (Exception e) {
            e.printStackTrace();
            response = new BaseResponse(StatusCode.Fail);
        }
        return response;
    }

    /**
     * 用户商城列表查询-分页查询
     *
     * @return
     */
    @RequestMapping(value = prefix + "/page/list", method = RequestMethod.GET)
    public BaseResponse pageList(Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageSize == null || pageNo <= 0 || pageSize <= 0) {
            pageNo = 1;
            pageSize = 2;
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);

        //TODO:调用服务提供方dubboOne提供的列表查询-分页查询功能
        try {
            response = dubboItemService.listPageItems(pageNo, pageSize);

        } catch (Exception e) {
            e.printStackTrace();
            response = new BaseResponse(StatusCode.Fail);
        }
        return response;
    }


    /**
     * 用户商城列表查询-分页查询-带参数模糊查询
     *
     * @return
     */
    @RequestMapping(value = prefix + "/page/list/params", method = RequestMethod.GET)
    public BaseResponse pageListParams(Integer pageNo, Integer pageSize, String search) {
        if (pageNo == null || pageSize == null || pageNo <= 0 || pageSize <= 0) {
            pageNo = 1;
            pageSize = 2;
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);

        //TODO:调用服务提供方dubboOne提供的列表查询-分页查询功能
        try {
            response = dubboItemService.listPageItemsParams(pageNo, pageSize, search);

        } catch (Exception e) {
            e.printStackTrace();
            response = new BaseResponse(StatusCode.Fail);
        }
        return response;
    }


}
