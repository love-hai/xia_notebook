package com.xhf.study.model;

import com.google.common.collect.Lists;
import com.xhf.study.service.tool.MyGsonUtils;
import lombok.Data;

import java.util.List;

@Data
public class NoteEventSubjectParam {

    private Byte noteEventSubjectType;  // 消息主体类型  1-店铺  2-商户  3-amazonAsin
    private String platFromCode; // 选择店铺后的平台
    private List<String> noteEventSubject = Lists.newArrayList();  // 消息主体内容

    public NoteEventSubjectParam() {
    }

    /**
     * MethodName: NoteEventSubjectParam
     * @Description: 初始化消息事件主体
     * @param noteEventSubject java.lang.String  :
     * @return:
     * @author xiahaifeng
     * @Date: 2023/11/16 10:39
     */
    public NoteEventSubjectParam(String noteEventSubject) {
        NoteEventSubjectParam temp = MyGsonUtils.gsonToBean(noteEventSubject, NoteEventSubjectParam.class);
        this.noteEventSubjectType = temp.noteEventSubjectType;
        this.platFromCode = temp.platFromCode;
        this.noteEventSubject = temp.noteEventSubject;
    }
    /**
     * MethodName: toString
     * @Description: 重写toString方法,返回json字符串
     * @param    :
     * @return: java.lang.String
     * @author xiahaifeng
     * @Date: 2023/11/16 10:39
     */
    @Override
    public String toString() {
        return MyGsonUtils.gsonString(this);
    }
}