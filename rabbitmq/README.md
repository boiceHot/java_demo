# rabbitmq
rabbitmq的应用

### 死信

死信，当一个消息在队列中变成死信之后，会被push到绑定的另一个队列中

死信应用场景有：订单超时未支付须释放商品、交易延时通知、过期数据清洗等

demo中死信相关的queue和exchange
- `Q-NOT-PAY`
- `Q-DL-NOT-PAY`
- `EXCHANGE-NOT-PAY`