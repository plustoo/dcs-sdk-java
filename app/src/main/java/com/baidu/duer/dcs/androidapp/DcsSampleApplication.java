/*
 * Copyright (c) 2017 Baidu, Inc. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.duer.dcs.androidapp;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * DcsSample application
 * <p>
 * Created by zhangyan42@baidu.com on 2017/5/11.
 */
public class DcsSampleApplication extends Application {
    private static volatile DcsSampleApplication instance = null;

    public void onCreate() {
        super.onCreate();
        instance = this;
        // LeakCanary.install(this);
        initLogger();
    }

    /**
     * 初始化日志工具
     */
    private void initLogger() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // Whether to show thread info or not. Default true
                .methodCount(1)         // How many method line to show. Default 2
                .methodOffset(2)        // Hides internal method calls up to offset. Default 5
                .tag("DcsSampleApplication")   // Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return true;
            }
        });
    }

    public static DcsSampleApplication getInstance() {
        return instance;
    }
}