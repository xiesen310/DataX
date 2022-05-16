# DataX ElasticSearchReader


---

## 1 快速介绍

[Datax](https://github.com/alibaba/DataX)
读取 elasticsearch 数据的插件

## 2 实现原理

使用 elasticsearch 的 rest api 接口， 批量读取 elasticsearch 的数据

## 3 功能说明

### 3.1 配置样例

#### es索引示例

```
{
	"source": "/var/log/monit.log",
	"measures": {},
	"timestamp": "2022-05-15T20:38:06.514+08:00",
	"offset": 1528294,
	"logTypeName": "default_analysis_template",
	"normalFields": {
		"source": "/var/log/monit.log",
		"deserializerTime": "2022-05-15T20:38:07.620+08:00",
		"collecttime_2": "2022-05-15T12:38:07.618Z",
		"logstash_deal_ip": "192.168.70.113",
		"logstash_deal_name": "zorkqa70113",
		"message": "[CST May 15 20:37:59] error    : Aborting queued event '/var/monit/1651866061_17f2ad0' - service ostemplate not found in monit configuration",
		"collecttime": "2022-05-15T12:38:06.514Z"
	},
	"dimensions": {
		"clustername": "集群",
		"hostname": "zorkqa70112",
		"appprogramname": "模块",
		"appsystem": "nuoya",
		"servicename": "模块",
		"ip": "192.168.70.112",
		"servicecode": "模块"
	}
}
```

#### job.json

```
{
  "job": {
    "setting": {
      "speed": {
         "channel": 1
      }
    },
    "content": [
      {
        "reader": {
          "name": "elasticsearchreader",
          "parameter": {
            "endpoint": "http://192.168.70.112:9200",
            "index": "dwd_default_log_2022.05.15",
            "type": "doc",
            "searchType": "dfs_query_then_fetch",
            "headers": {
            },
            "search": [
              {
                "size": 5,
                "query": {
                  "bool": {
                    "must": [
                      {
                        "match_phrase": {
                          "logTypeName": "default_analysis_template"
                        }
                      }
                    ]
                  }
                }
              }
            ],
            "table":{
              "name": "default_analysis_template",
              "filter": "logTypeName != null",
              "nameCase": "UPPERCASE",
              "column": [
                {
                  "name": "logTypeName",
                  "alias": "logTypeName", 
                },
                {
                  "name": "timestamp"
                },
                {
                  "name": "source"
                },
                {
                  "name": "offset"
                },
                {
                  "name": "dimensions",
                  "child": [
                    {
                      "name": "appsystem"
                    },
                    {
                      "name": "ip"
                    }
                  ]
                },
                { 
                  "name": "normalFields",
                  "child": [
                    { 
                      "name": "message"
                    },
                    { 
                      "name": "collecttime"
                    }
                  ]
                }
              ]
            }
          }
        },
        "writer": {
          "name": "streamwriter",
          "parameter": {
            "print": true,
            "encoding": "UTF-8"
          }
        }
      }
    ]
  }
}
```

#### 3.2 参数说明

* endpoint
  * 描述：ElasticSearch的连接地址
  * 必选：是
  * 默认值：无

* accessId
  * 描述：http auth中的user
  * 必选：否
  * 默认值：空

* accessKey
  * 描述：http auth中的password
  * 必选：否
  * 默认值：空

* index
  * 描述：elasticsearch中的index名
  * 必选：是
  * 默认值：无

* type
  * 描述：elasticsearch中index的type名
  * 必选：否
  * 默认值：index名

* timeout
  * 描述：客户端超时时间
  * 必选：否
  * 默认值：600000

* discovery
  * 描述：启用节点发现将(轮询)并定期更新客户机中的服务器列表。
  * 必选：否
  * 默认值：false

* compression
  * 描述：http请求，开启压缩
  * 必选：否
  * 默认值：true

* multiThread
  * 描述：http请求，是否有多线程
  * 必选：否
  * 默认值：true

* searchType
  * 描述：搜索类型
  * 必选：否
  * 默认值：dfs_query_then_fetch
 
* headers
  * 描述：http请求头
  * 必选：否
  * 默认值：空
  
* scroll
  * 描述：滚动分页配置
  * 必选：否
  * 默认值：空

* search
  * 描述：json格式api搜索数据体
  * 必选：是
  * 默认值：[]

* table
  * 描述: 数据读取规则配置，name命名，nameCase全局字段大小写，filter使用ognl表达式进行过滤
  * 必选: 是
  * 默认值: 无

* column
  * 描述：需要读取的字段，name对应es文档的key，alias为最终记录的字段名如果为空则使用name，value表示字段为常量，child为嵌套对象
  * 必选：是
  * 默认值：无
  
## 4 性能报告

略

## 5 约束限制

* filter 使用 ognl 表达式，根对象为整个 table 对象，key 为 column 最终写入的名称

## 6 FAQ