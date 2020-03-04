$(function(){
    $('#loginButton').click(function() {
        var loginUsername = $('#loginUsername').val();
        var loginPassword = $('#loginPassword').val();

        if(loginUsername == null || loginUsername == "" || loginPassword == "" || loginPassword == null){
            alert("有输入为空,请检查");
        } else {
            $.ajax({
                type: "post",
                url: "/login",
                data: {
                    loginUsername: loginUsername,
                    loginPassword: loginPassword
                },
                dataType: "JSON",
                success: function (data) {
                    if (data.code == 202) {
                        sessionStorage.setItem("uid",data.result.uid);
                        location.href = "test.html";
                    } else if(data.code == 200){
                        alert("账号不存在");
                    } else if(data.code == 201){
                        alert("密码错误");
                    }
                },
                error : function (data) {
                    alert("出错：" + data.code);
                }
            })
        }
    })
})