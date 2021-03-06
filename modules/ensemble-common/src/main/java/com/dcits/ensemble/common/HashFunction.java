package com.dcits.ensemble.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Tim on 2015/6/12.
 */
public class HashFunction {

    private static final Logger logger = LoggerFactory.getLogger(HashFunction.class);

    /**
     * 对三个数据库进行散列分布 1、返回其他值，没有在配置文件中配置的，如负数等，在默认数据库中查找
     * 2、比如现在配置文件中配置有三个结果进行散列，如果返回为0，那么apply方法只调用一次，如果返回为2，
     * 那么apply方法就会被调用三次，也就是每次是按照配置文件的顺序依次的调用方法进行判断结果，而不会缓存方法返回值进行判断
     */
    public int apply(Long userId) {
        logger.debug("userId：" + userId);
        int result = (int) (userId % 2);
        logger.debug("在第" + (result + 1) + "个数据库中");
        return result;
    }

    /**
     * 截取后两位
     *
     * @param value
     * @return
     * @description
     * @version 1.0
     * @author Tim
     * @update 2015年2月13日 下午4:10:30
     */
    public int cutLast2(String value) {
        return Long.valueOf(
                value.substring(value.length() > 2 ? value.length() - 2 : 0))
                .intValue();
    }
    
    /**
     * 指定起始位置和要截取的位数,并转换为int
     */
    public int subStringtoInt(String value, int begin, int end){
    	return Long.valueOf(value.substring(begin, end)).intValue();
    	
    }

    /**
     * 取余算法
     *
     * @param dividend
     * @param divisor
     * @return
     * @description
     * @version 1.0
     * @author Tim
     * @update 2015年3月2日 下午4:22:43
     */
    public int mod(int dividend, int divisor) {
        logger.debug("被除数：" + dividend + " 除数：" + divisor);
        int result = (int) (dividend % divisor);
        logger.debug("在第" + (result + 1) + "个数据库中");
        return result;
    }
}
