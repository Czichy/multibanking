
# UpdateBankConnectionParams

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**bankConnectionId** | **Long** | Bank connection identifier | 
**bankingPin** | **String** | Online banking PIN. If a PIN is stored in the bank connection, then this field may remain unset. If the field is set though then it will always be used (even if there is some other PIN stored in the bank connection) |  [optional]
**importNewAccounts** | **Boolean** | Whether new accounts that have not yet been imported will be imported or not. Default is false. &lt;br/&gt;NOTES:&lt;br/&gt;&lt;br/&gt;&amp;bull; For best performance of the bank connection update, you should not enable this flag unless you really expect new accounts to be available in the connection. It is recommended to let your users tell you through your application when they want the service to look for new accounts.&lt;br/&gt;&amp;bull; If you have imported a bank connection using specific &lt;code&gt;accountTypeIds&lt;/code&gt; (e.g. &lt;code&gt;1,2&lt;/code&gt; to import checking and saving accounts), you would import all other accounts (e.g. security accounts or credit cards) by setting &lt;code&gt;importNewAccounts&lt;/code&gt; to &lt;code&gt;true&lt;/code&gt;. To avoid importing account types that you are not interested in, make sure this field is undefined or set to false. |  [optional]
**skipPositionsDownload** | **Boolean** | Whether to skip the download of transactions and securities or not. If set to true, then finAPI will download just the accounts list with the accounts&#39; information (like account name, number, holder, etc), as well as the accounts&#39; balances (if possible), but skip the download of transactions and securities. Default is false.&lt;br/&gt;NOTES:&lt;br/&gt;&lt;br/&gt;&amp;bull; If you skip the download of transactions and securities during an import or update, you can still download them on a later update (though you might not get all positions at a later point, because the date range in which the bank servers provide this data is usually limited). However, once finAPI has downloaded the transactions or securities for the first time, you will not be able to go back to skipping the download of transactions and securities! In other words: Once you make your first request with &lt;code&gt;skipPositionsDownload&#x3D;false&lt;/code&gt; for a certain bank connection, you will no longer be able to make a request with &lt;code&gt;skipPositionsDownload&#x3D;true&lt;/code&gt; for that same bank connection.&lt;br/&gt;&amp;bull; If this bank connection is updated via finAPI&#39;s automatic batch update, then transactions and security positions &lt;u&gt;will&lt;/u&gt; be downloaded in any case!&lt;br/&gt;&amp;bull; For security accounts, skipping the downloading of the securities might result in the account&#39;s balance also not being downloaded. |  [optional]


