/*
 Navicat Premium Data Transfer

 Source Server         : mydatabase
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 192.168.31.136:3306
 Source Schema         : ebook

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 17/04/2021 10:46:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mAbstract` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `filePath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phases` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `imagePath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('算法导论', '托马斯·科尔曼等', '《算法导论》自第一版出版以来，已经成为世界范围内广泛使用的大学教材和专业人员的标准参考手册。本书全面论述了算法的内容，从一定深度上涵盖了算法的诸多方面，同时其讲授和分析方法又兼顾了各个层次读者的接受能力。', '计算机/算法', '/pdf/algorithm.pdf', '前言（Preface）\r\n第一部分（Part I） 基础（Foundations）\r\n第1章 计算中算法的角色（The Role of Algorithms in Computing）\r\n第2章 开始（Getting Started）\r\n第3章 函数的增长率（Growth of Functions）\r\n第4章 递归（Recurrences）\r\n第5章 概率分析与随机化算法（Probabilistic Analysis and Randomized Algorithms）\r\n第二部分（Part II） 排序与顺序统计量（Sorting and Order Statistics）\r\n第6章 堆排序（Heapsort）\r\n第7章 快速排序（Quicksort）\r\n第8章 线性时间中的排序（Sorting in Linear Time）\r\n第9章 中值与顺序统计（Medians and Order Statistics）\r\n第三部分（Part III） 数据结构（Data Structures）\r\n第10章 基本的数据结构（Elementary Data Structures）\r\n第11章 散列表（Hash Tables）\r\n第12章 二叉查找树（Binary Search Trees）\r\n第13章 红-黑树（Red-Black Trees）\r\n第14章 扩充的数据结构（Augmenting Data Structures）\r\n第四部分（Part IV） 高级设计与分析技术（Advanced Design and Analysis Techniques）\r\n第15章 动态规划（Dynamic Programming）\r\n第16章 贪婪算法（Greedy Algorithms）\r\n第17章 分摊分析（Amortized Analysis）\r\n第五部分（Part V） 高级的数据结构（Advanced Data Structures）\r\n第18章 B-树（B-Trees）\r\n第19章 二项式堆（Binomial Heaps）\r\n第20章 斐波纳契堆（Fibonacci Heaps）\r\n第21章 不相交集的数据结构（Data Structures for Disjoint Sets）\r\n第六部分（Part VI） 图算法（Graph Algorithms）\r\n第22章 基本的图算法（Elementary Graph Algorithms）\r\n第23章 最小生成树（Minimum Spanning Trees）\r\n第24章 单源最短路径（Single-Source Shortest Paths）\r\n第25章 全对的最短路径（All-Pairs Shortest Paths）\r\n第26章 最大流（Maximum Flow）\r\n第七部分（Part VII） 算法问题选编（Selected Topics）\r\n第27章 排序网络（Sorting Networks）\r\n第28章 矩阵运算（Matrix Operations）\r\n第29章 线性规划（Linear Programming）\r\n第30章 多项式与快速傅里叶变换（Polynomials and the FFT）\r\n第31章 数论算法（Number-Theoretic Algorithms）\r\n第32章 字符串匹配（String Matching）\r\n第33章 计算几何学（Computational Geometry）\r\n第34章 NP-完备性（NP-Completeness）\r\n第35章 近似算法（Approximation Algorithms）\r\n第八部分（Part VIII） 附录：数学基础知识（Mathematical Background）\r\n附录A 求和（Summations）\r\n附录B 集合等离散数学内容（Sets, Etc.）\r\n附录C 计数与概率（Counting and Probability）\r\n附录D 矩阵（Matrix）\r\n参考文献（Bibliography）\r\n索引（Index）', '/img/algorithm.jpg');
INSERT INTO `book` VALUES ('机器学习', '周志华', '机器学习是计算机科学与人工智能的重要分支领域. 本书作为该领域的入门教材，在内容上尽可能涵盖机器学习基础知识的各方面。 为了使尽可能多的读者通过本书对机器学习有所了解。', '计算机/人工智能', '/pdf/machinelearning.pdf', '第1章 1\r\n1.1 引言 1\r\n1.2 基本术 2\r\n1.3 假设空间 4\r\n1.4 归纳偏好 6\r\n1.5 发展历程 10\r\n1.6 应用现状 13\r\n1.7 阅读材料 16\r\n第2章 模型评估与选择 23\r\n2.1 经验误差与过拟合 23\r\n2.2 评估方法 24\r\n2.3 性能度量 28\r\n2.4 比较检验 37\r\n2.5 偏差与方差 44\r\n2.6 阅读材料 46\r\n第3章 线性模型 53\r\n3.1 基本形式 53\r\n3.2 线性回归 53\r\n3.3 对数几率回归 57\r\n3.4 线性判别分析 60\r\n3.5 多分类学习 63\r\n3.6 类别不平衡问题 66\r\n3.7 阅读材料 67\r\n第4章 决策树 73\r\n4.1 基本流程 73\r\n4.2 划分选择 75\r\n4.3 剪枝处理 79\r\n4.4 连续与缺失值 83\r\n4.5 多变量决策树 88\r\n4.6 阅读材料 92\r\n第5章 神经网络 97\r\n5.1 神经元模型 97\r\n5.2 感知机与多层网络 98\r\n5.3 误差逆传播算法 101\r\n5.4 全局最小与局部极小 106\r\n5.5 其他常见神经网络 108\r\n5.6 深度学习 113\r\n5.7 阅读材料 115\r\n第6章 支持向量机 121\r\n6.1 间隔与支持向量 121\r\n6.2 对偶问题 123\r\n6.3 核函数 126\r\n6.4 软间隔与正则化 129\r\n6.5 支持向量回归 133\r\n6.6 核方法 137\r\n6.7 阅读材料 139\r\n第7章 贝叶斯分类器 147\r\n7.1 贝叶斯决策论 147\r\n7.2 极大似然估计 149\r\n7.3 朴素贝叶斯分类器 150\r\n7.4 半朴素贝叶斯分类器 154\r\n7.5 贝叶斯网 156\r\n7.6 EM算法 162\r\n7.7 阅读材料 164\r\n第8章 集成学习 171\r\n8.1 个体与集成 171\r\n8.2 Boosting 173\r\n8.3 Bagging与随机森林 178\r\n8.4 结合策略 181\r\n8.5 多样性 185\r\n8.6 阅读材料 190\r\n第9章 聚类 197\r\n9.1 聚类任务 197\r\n9.2 性能度量 197\r\n9.3 距离计算 199\r\n9.4 原型聚类 202\r\n9.5 密度聚类 211\r\n9.6 层次聚类 214\r\n9.7 阅读材料 217\r\n第10章 降维与度量学习 225\r\n10.1 k近邻学习 225\r\n10.2 低维嵌入 226\r\n10.3 主成分分析 229\r\n10.4 核化线性降维 232\r\n10.5 流形学习 234\r\n10.6 度量学习 237\r\n10.7 阅读材料 240\r\n第11章 特征选择与稀疏学习 247\r\n11.1 子集搜索与评价 247\r\n11.2 过滤式选择 249\r\n11.3 包裹式选择 250\r\n11.4 嵌入式选择与L$_1$正则化 252\r\n11.5 稀疏表示与字典学习 254\r\n11.6 压缩感知 257\r\n11.7 阅读材料 260\r\n第12章 计算学习理论 267\r\n12.1 基础知识 267\r\n12.2 PAC学习 268\r\n12.3 有限假设空间 270\r\n12.3.1 可分情形 270\r\n12.3.2 不可分情形 272\r\n12.4 VC维 273\r\n12.5 Rademacher复杂度 279\r\n12.6 稳定性 284\r\n12.7 阅读材料 287\r\n第13章 半监督学习 293\r\n13.1 未标记样本 293\r\n13.2 生成式方法 295\r\n13.3 半监督SVM 298\r\n13.4 图半监督学习 300\r\n13.5 基于分歧的方法 304\r\n13.6 半监督聚类 307\r\n13.7 阅读材料 311\r\n第14章 概率图模型 319\r\n14.1 隐马尔可夫模型 319\r\n14.2 马尔可夫随机场 322\r\n14.3 条件随机场 325\r\n14.4 学习与推断 328\r\n14.5 近似推断 331\r\n14.5.1 MCMC采样 331\r\n14.5.2 变分推断 334\r\n14.6 话题模型 337\r\n14.7 阅读材料 339\r\n第15章 规则学习 347\r\n15.1 基本概念 347\r\n15.2 序贯覆盖 349\r\n15.3 剪枝优化 352\r\n15.4 一阶规则学习 354\r\n15.5 归纳逻辑程序设计 357\r\n15.6 阅读材料 363\r\n第16章 强化学习 371\r\n16.1 任务与奖赏 371\r\n16.2 $K$-摇臂赌博机 373\r\n16.3 有模型学习 377\r\n16.4 免模型学习 382\r\n16.5 值函数近似 388\r\n16.6 模仿学习 390\r\n16.7 阅读材料 393\r\n附录 399', '/img/machinelearning.jpg');
INSERT INTO `book` VALUES ('JavaScript高级程序设计', '(美)(Nicholas C.Zakas)扎卡斯', '全书从JavaScript 语言实现的各个组成部分——语言核心、DOM、BOM、事件模型讲起，深入浅出地探讨了面向对象编程、Ajax 与Comet 服务器端通信，HTML5 表单、媒体、Canvas（包括WebGL）及Web Workers、地理定位、跨文档传递消息、客户端存储（包括IndexedDB）等新API，还介绍了离线应用和与维护、性能、部署相关的最佳开发实践。', '计算机/编程语言', '/pdf/javascript.pdf', '第1章 JavaScript是什么\r\n1.1 历史简述\r\n1.2 JavaScript实现\r\n1.3 小结\r\n第2章 ECMAScript基础。\r\n2.1 语法\r\n2.2 变量\r\n2.3 关键字\r\n2.4 保留字\r\n2.5 原始值和引用值\r\n2.6 原始类型\r\n2.7 转换\r\n2.8 引用类型\r\n2.9 运算符\r\n2.10 语句\r\n2.11 函数\r\n2.12 小结\r\n第3章 对象基础\r\n3.1 面向对象术语\r\n3.2 对象应用\r\n3.3 对象的类型：本地对象\r\n3.4 作用域\r\n3.5 定义类或对象\r\n3.6 修改对象\r\n3.7 小结\r\n第4章 继承\r\n4.1 继承机制实例\r\n4.2 继承机制的实现\r\n4.3 其他继承方式\r\n4.4 小结\r\n第5章 浏览器中的JavaScript\r\n第6章 DOM基础\r\n第7章 正则表达式\r\n第8章 检测浏览器和操作系统\r\n第9章 事件\r\n第10章 高级DOM技术\r\n第11章 表单和数据完整性\r\n第12章 表格排序\r\n第13章 拖放\r\n第14章 错误处理\r\n第15章 JavaScript中的XML\r\n第16章 客户端与服务器端的通信\r\n第17章 Web服务\r\n第18章 与插件进行交互\r\n第19章 部署问题\r\n第20章 JavaScript的未来\r\n索引', '/img/javascript.jpg');
INSERT INTO `book` VALUES ('如何阅读一本书', '[美] 莫提默·J. 艾德勒、查尔斯·范多伦', '《如何阅读一本书》初版于1940年，1972年大幅增订改写为新版。不懂阅读的人，初探阅读的人，读这本书可以少走冤枉路。对阅读有所体会的人，读这本书可以有更深的印证和领悟。', '人文/阅读', '/pdf/howtoreadabook.pdf', '序言\r\n第一篇 阅读的层次\r\n第一章 阅读的活力与艺术\r\n第二章 阅读的层次\r\n第三章 阅读的第一个层次：基础阅读\r\n第四章 阅读的第二个层次：检视阅读\r\n第五章 如何做一个自我要求的读者\r\n第二篇 阅读的第三个层次：分析阅读\r\n第六章 一本书的分类\r\n第七章 透视一本书\r\n第八章 与作者找出共通的词义\r\n第九章 判断作者的主旨\r\n第十章 公正地评断一本书\r\n第十一章 赞同或反对作者\r\n第十二章 辅助阅读\r\n第三篇 阅读不同读物的方法\r\n第十三章 如何阅读实用型的书\r\n第十四章 如何阅读想像文学\r\n第十五章 阅读故事、戏剧与诗的一些建议\r\n第十六章 如何阅读历史书\r\n第十七章 如何阅读科学与数学\r\n第十八章 如何阅读哲学书\r\n第十九章 如何阅读社会科学\r\n第四篇 阅读的最终目标\r\n第二十章 阅读的第四个层次：主题阅读\r\n第二十一章 阅读与心智的成长\r\n附录一 建议阅读书目\r\n附录二 四种层次阅读的练习与测验\r\n索引', '/img/howtoreadabook.jpg');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('san', 'JavaScript高级程序设计');
INSERT INTO `collection` VALUES ('admin', '机器学习');
INSERT INTO `collection` VALUES ('qwe', '机器学习');

-- ----------------------------
-- Table structure for role_url
-- ----------------------------
DROP TABLE IF EXISTS `role_url`;
CREATE TABLE `role_url`  (
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_url
-- ----------------------------
INSERT INTO `role_url` VALUES ('', '');

-- ----------------------------
-- Table structure for user_data
-- ----------------------------
DROP TABLE IF EXISTS `user_data`;
CREATE TABLE `user_data`  (
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_data
-- ----------------------------
INSERT INTO `user_data` VALUES ('admin', '123456', '4545451', 'admin');
INSERT INTO `user_data` VALUES ('user1', '123', '88888', 'user');
INSERT INTO `user_data` VALUES ('san', '123456', '111444555', 'USER');
INSERT INTO `user_data` VALUES ('qwe', 'qwe', '123', 'USER');

SET FOREIGN_KEY_CHECKS = 1;
