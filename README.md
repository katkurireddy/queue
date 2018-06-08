# queue
FileWather.java responsible for continuously monitoring the directory specified in file.path param on application.yml file.
When a new file arrives, it gets validated and sent to the queue

Sample file shuould be like the folowing. It is attached for reference.
Given file in the test is malformed. so it is modified like below for xml parsing.

<?xml version='1.0' encoding='UTF-8' standalone='yes'?>
<Orders>
<Order><account>AX001</accont><SubmittedAt>1507060723641</SubmittedAt><ReceivedAt>1507060723642</ReceivedAt><market>VOD.L</market><action>BUY</action><size>100</size></Order>
<Order><account>AX002</accont><SubmittedAt>1507060723651</SubmittedAt><ReceivedAt>1507060723652</ReceivedAt><market>VOD.L</market><action>BUY</action><size>200</size></Order>
</Orders>
