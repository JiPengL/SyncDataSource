package com.dync.annotion;

import java.lang.annotation.*;

/**
 * @author liujipeng
 * @date 2020/8/11 15:31
 * @mail liujipeng@cloud-er.com
 * @desc ...
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Master {

}
