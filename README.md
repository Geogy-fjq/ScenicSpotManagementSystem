# ScenicSpotManagementSystem
## 基于WindowBuilder——景区信息管理系统  
### 系统介绍  
    系统用户包括管理员和游客两类，管理员负责管理景区的景点维护；游客可以根据自己的需求对景区进行各种信息查询，及路线规划等。  
    主程序应用菜单选项包含功能：  
        -	管理员登录  
        -	景区景点分布图  
        -	景点的查找与排序  
        -	导游线路图  
        -	两个景点间的最短路径和最短距离  
        -	停车场车辆进出记录信息  
    管理员模块主要负责维护整个景区景点以及发布各项通知。管理员登录后可以进行：  
        -	景点的插入和删除  
        -	路的插入和删除  
        -	发布通知通告  
        
### 需求分析  
(1)游客需求：  
1、实现“查看景点分布图”功能：能够查看整个景区的景点分布图。  
2、实现“查看导游线路图”功能：能够根据用户输入的景点名称，形成一条经过景区所有景点的最短回路，并输出该回路路径，计算总路程。  
3、实现“景点查找”功能：分为精确查找和模糊查找两种。游客可以根据准确的景点名称查找到该景点的介绍，根据任意一个字或字段查找到景点名称中包含该字或字段的全部景点。  
4、实现“景点排序”功能：能够根据景点欢迎度、岔路数、有无休息区、有无厕所四种情况对景区中的所有景点进行相应的排序，输出排序后的景点。  
5、实现“查询景点间的最短路径和距离”功能：能够根据游客输入的起始景点和目的景点的名称，计算并输出这两个景点间的最短路径和距离，以及该最短路径情况下预计要花费的时间。  
(2)管理员需求：  
1、实现“增添景点”功能：在文件和邻接表中分别增添景点，并有成功与否的消息提示。其中，管理员在邻接表中增添景点，要求游客系统的邻接表同时被更新。  
2、实现“删除景点”功能：在文件和邻接表中分别删除景点，并有成功与否的消息提示。其中，管理员在邻接表中删除景点，要求游客系统的邻接表同时被更新。  
3、实现“增添线路”功能：在文件和邻接表中分别增添线路，并有成功与否的消息提示。其中，管理员在邻接表中增添线路，要求游客系统的邻接表同时被更新。  
4、实现“删除线路”功能：在文件和邻接表中分别删除线路，并有成功与否的消息提示。其中，管理员在邻接表中删除线路，要求游客系统的邻接表同时被更新。  
5、实现“发布公告”功能：要求管理员在执行完以上功能之后发布公告，同时游客系统的公告栏上的通知被刷新为管理员最新发布的公告。  
(3)停车场需求：  
1、实现“车辆到达”功能：当车辆到达时，输入车牌号和到达时间，能够输出该车牌号的车辆在停车场中或是在便道上的停放位置。设置停车场的最大停车数量，当停车场停满时，车辆暂时停放到便道上；当停车场有车辆开出时，便道上的车辆按照“先进先出”的原则依次停放到停车场中。  
2、实现“车辆离开”功能：当车辆离开时，输入车牌号和离开时间，能够输出该车牌号的车辆已经离开停车场的消息，并输出该车辆在停车场中的停放时间和所需费用。停车场的停放依照“先进后出”的原则，当停车场内某辆车要离开时，在它之后进入的车辆必须先退出车场为它让路，先进停车场的后退出，后进车场的先退出。因此，还需要一个“先进后出”的让路停车场地来提供车辆离开时其它车辆的让路功能。当车辆退出，有便道上的车辆进入停车场时，能够输出该车牌号的车辆在停车场中的停放位置。  
3、实现“输入提示”功能：在相同的车牌号的车辆重复停入或者还未停入停车场的车辆离开时，会有相应的提示来请求用户重新输入。  

### 系统设计  
    分为三个模块来实现景区信息管理系统的功能：游客模块、管理员模块和停车场模块。其中，游客模块和管理员模块应实现信息的交互，停车场系统应实现信息的记录，整个系统采用单例模式设计。  
    编写多种数据结构和相应算法，用来实现该系统的功能。数据结构包括：顺序表、链表、邻接表、邻接矩阵、队列、栈等，算法包括：Dijkstra最短路径算法、最小生成树Prim算法、快速排序等。  
    编写类来封装景点、车辆等对象的全部属性。  
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p1.png" width="800"></div>  

### 成果展示
1、菜单及界面：
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p2.png" width="800"></div>  
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p3.png" width="800"></div>  
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p4.png" width="800"></div>  
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p5.png" width="800"></div>  
2、用户系统中的“查看景点分布图”：
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p6.png" width="800"></div>  
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p7.png" width="800"></div>  
3、用户系统中的“查看导游线路图（回路）”：
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p8.png" width="800"></div>  
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p9.png" width="800"></div>  
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p10.png" width="800"></div> 
4、用户系统中的“景点排行”，有景点欢迎度、岔路数、有无休息区、有无厕所四种排行可以选择：
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p11.png" width="800"></div> 
5、用户系统中的“景点查找”，可进行精确查找和模糊查找：
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p12.png" width="800"></div> 
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p13.png" width="800"></div> 
6、用户系统中的“查询景点间的最短路径和距离”：
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p14.png" width="800"></div>
7、用户系统中的“公告栏”，当管理员界面发布消息时，会显示最新消息，初始值为“暂无公告”：  
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p15.png" width="800"></div><div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p16.png" width="800"></div>
8、管理员系统中的“增添景点”、“删除景点”、“增添路线”、“删除路线”：
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p17.png" width="800"></div><div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p18.png" width="800"></div><div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p19.png" width="800"></div><div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p20.png" width="800"></div>
同时修改文件和邻接表，当操作完成后，文件中会相应增删，用户界面的邻接矩阵也会相应地改变。有操作的回馈消息提示：
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p21.png" width="800"></div>
9、停车场系统中的“车辆到达”显示相应通知：
停入停车场：
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p22.png" width="800"></div>
停车场已满，停入便道：
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p23.png" width="800"></div>
10、停车场系统中的“车辆离开”显示相应通知：
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p24.png" width="800"></div>
11、停车场系统中，当车牌号相同的车到达或者未停入的车离开时，提示信息：
<div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p25.png" width="800"></div><div align=center><img src="https://github.com/Geogy-fjq/ScenicSpotManagementSystem/blob/master/READMEPhoto/p26.png" width="800"></div>

