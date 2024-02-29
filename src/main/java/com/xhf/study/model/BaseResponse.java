package com.xhf.study.model;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * erp的bizData返回值
 *
 * @author xiahaifeng
 * @since 2024/1/3 8:36
 */
@EqualsAndHashCode()
@Data
@Slf4j
public class BaseResponse<T> {
    public static String STATUS_KEY = "status";
    public static String BIZ_DATA = "bizData";
    public static String POINT = ".";
    public static String MESSAGE = "message";
    public static Gson gson = new Gson();
    private Integer status;
    private String message;
    @SerializedName("bizData")
    private T bizData;

    /**
     * MethodName: ListResponse <br>
     * Description: 将result中的bizData转化为列表对象 <br>
     * @param result java.lang.String    :
     * @param clazz  java.lang.Class<?>  :
     * @author xiahaifeng
     * @since 2024/2/27 13:04
     */
    public <E> void ListResponse(String result, Class<E> clazz) throws Exception {
        if (StringUtils.isEmpty(result)) {
            return;
        }
        JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
        Integer status = jsonObject.get(STATUS_KEY).getAsInt();
        String message = jsonObject.get(MESSAGE).getAsString();
        this.setStatus(status);
        this.setMessage(message);
        if (null == jsonObject.get(BIZ_DATA)) {
            return;
        }
        if (jsonObject.get(BIZ_DATA).isJsonNull()) {
            return;
        }
        try {
            JsonArray array = jsonObject.get(BIZ_DATA).getAsJsonArray();
            if (null == array || array.size() == 0) {
                return;
            }
            List<E> list = new ArrayList<>();
            for (final JsonElement elem : array) {
                list.add(gson.fromJson(elem, clazz));
            }
            this.setBizData((T) list);
        } catch (Exception e) {
            throw new Exception("BizData转化数组失败", e);
        }
    }

    /**
     * MethodName: ObjectResponse <br>
     * Description: 将result中的bizData转化为对象 <br>
     *
     * @param result java.lang.String    :
     * @param clazz  java.lang.Class<T>  :
     * @author xiahaifeng
     * @since 2024/2/27 13:06
     */
    public void ObjectResponse(String result, Class<T> clazz) throws Exception {
        if (StringUtils.isEmpty(result)) {
            return;
        }
        JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
        Integer status = jsonObject.get(STATUS_KEY).getAsInt();
        String message = jsonObject.get(MESSAGE).getAsString();
        this.setStatus(status);
        this.setMessage(message);
        if (null == jsonObject.get(BIZ_DATA)) {
            return;
        }
        // 如果泛型是Object类型
        if (jsonObject.get(BIZ_DATA).isJsonNull()) {
            return;
        }
        try {
            this.setBizData(gson.fromJson(jsonObject.get(BIZ_DATA), clazz));
        } catch (Exception e) {
            throw new Exception("BizData转化对象失败", e);
        }
    }
}
