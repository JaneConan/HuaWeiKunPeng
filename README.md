﻿﻿﻿﻿﻿# ﻿﻿﻿﻿﻿HuaWeiKunPeng> 2019年华为云鲲鹏开发者大赛天津师范大学电子与通信工程、人工智能学院解决方案工程分为三端-  a（ai）-  c（client）-  s（server）试题工程结构│  run.bat             #系统启动脚本，包括client/server/ui三套程序，自动比赛│  submit.bat          #将client目录打包成比赛规定格式的zip包，用于提交作品│  ├─client│  │   gameclient.bat  #选手程序比赛入口文件，务必存在│  │  │  ├─bin│  │   client.exe       #放置执行程序，由参赛者替换│  │      │  └─src                 #放置程序源码路径，由参赛者提供│ ├─demo_proj│  ││  └─demo_for_c           #C/C++基础工程，提供简单消息通讯│  │   │  └─demo_for_java        #JAVA版基础工程，提供简单消息通讯│  │   │  └─demo_for_python      #Python版基础工程，提供简单消息通讯││├─ai│  │ gameclient.bat      #机器人AI启动入口，模拟对战│  │  │  └─bin│      ai.exe              #AI程序│        ├─server│      gameserver.bat      #启动server程序的批处理│      map1.txt            #样例地图文件，server运行必备│      BattleServer.exe    #server程序│      └─ui                       #单机图形界面                #ToDo使用试题工程，demo_proj中任意语言进行实验，并最终实现抢高分### 初赛赛题（1）赛题简介：初赛赛题内容：用户基于鲲鹏云服务器RC3 2C7G 1台，并根据大赛组织方提供的赛题详细说明文档，进行'化鲲为鹏’的探险类游戏策略开发，通过与大赛组提供的AI程序对决，以获取最佳对战战绩（2）赛题详细说明及试题工程（官方demo）（3）赛制 ：选拔赛    7.17-8.23：报名及初赛，8月23日24:00截止报名，共一轮，选手与AI对战，n进128；8月24日公布复赛晋级名单，以及复赛赛题A  面向所有正常报名参赛队伍，与大赛提供的AI程序进行对决，进行抢分排位，抢分排名前128 的队伍成功晋级；（4）作品提交要求：初赛在左侧【提交作品】页内提交代码A  作品软件包命名规则统一为队长华为云账号.zip，大小不超过20mB  软件包内需要包含一个gameclient.sh文件，并且该文件可以使用鲲鹏CPU对应的linux操作系统中的bash指令运行，该程序需要支持3个连续的参数，分别为 队伍id（整数）、server ip地址（字符串）、port（数字）