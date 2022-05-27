function jQuery(selector) {
    if (typeof selector === "string") {
        if (selector.charAt(0) === "#") {
            domObj = document.getElementById(selector.slice(1));
            return new jQuery();
        }
    } else if (typeof selector === "function") {
        window.onload = selector
    }
    this.html = function (htmlText) {
        domObj.innerHTML = htmlText
    }
    this.click = function (func) {
        domObj.onclick = func
    }
    this.focus = function (func) {
        domObj.onfocus = func
    }
    this.change = function (func) {
        domObj.onchange = func
    }
    this.val = function (value) {
        if (value === undefined) {
            return domObj.value
        } else{
            return domObj.value = value
        }
    }
    /**
     * @param jsonArgs 参数为一个json对象
     * @param jsonArgs.type GET/POST
     * @param jsonArgs.url 请求的url
     * @param jsonArgs.async 同步还是异步 true表示异步 false表示同步
     * @param jsonArgs.data  请求时提交的数据
     * @param jsonArgs.success 返回信息
     */
    jQuery.ajax = function (jsonArgs) {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {

            if (this.readyState === 4) {
                if (this.status === 200) {
                    //我们的工具类封装先封装json
                    jsonObj= JSON.parse(this.responseText);
                    jsonArgs.success(jsonObj)
                    // document.getElementById("mydiv").innerHTML = jsonObj.username
                } else {
                    alert(this.status)
                }
            }
        }

        if (jsonArgs.type.toUpperCase() === "POST"){
            xhr.open(jsonArgs.type.toUpperCase(), jsonArgs.url, jsonArgs.async)
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
            xhr.send(jsonArgs.data)
        }
        if (jsonArgs.type.toUpperCase() === "GET"){
            xhr.open(jsonArgs.type.toUpperCase(),jsonArgs.url+"?"+jsonArgs.data,jsonArgs.async)
            xhr.send()
        }
    }
}
$ = jQuery
new jQuery()