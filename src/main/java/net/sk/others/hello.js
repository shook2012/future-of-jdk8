//say hello
print("hello,java 8");

//function 1
var fun1 = function(name) {
    print('Hi there from Javascript, ' + name);
    return "greetings from javascript";
};

//function 2
var fun2 = function (object) {
    print("JS Class Definition: " + Object.prototype.toString.call(object));
};

// load js lib from remote
/*
load('http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore-min.js');

var odds = _.filter([1, 2, 3, 4, 5, 6], function (num) {
    return num % 2 == 1;
});

 print("odds:" + odds);
*/

//invoke java from js
var myClass = Java.type('net.sk.others.ScriptEngineManagerTest');

var result = myClass.fun1('韩湘子');
print(result);

// class java.lang.Integer
myClass.fun2(123);

// class java.lang.Double
myClass.fun2(49.99);

// class java.lang.Boolean
myClass.fun2(true);

// class java.lang.String
myClass.fun2("何仙姑")
