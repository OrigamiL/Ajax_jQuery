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
}
$ = jQuery