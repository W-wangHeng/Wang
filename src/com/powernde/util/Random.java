package com.powernde.util;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: SpringMvcProject
 * @Package: com.powernde.util
 * @Description: java类作用描述
 * @Author: 王恒
 * @CreateDate: 2020/12/13 18:55
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class Random {

    public int randomNum() {

        int random = (int) ( (Math.random() *(999999999) +100000000) +1000000000 );

        return random;
    }

/*    public static void main(String[] args) {

        for (int i = 0; i <100 ; i++) {
            System.out.println(new Random().randomNum());
        }

    }*/
}
