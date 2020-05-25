var main ={
    init : function(){
        var _this = this;
        $('#register').on('click',function(){
            _this.register();
        });

    },
    register : function(){
        var data = {
            colNum: $('#colNum').val(),
            name: $('#name').val(),
            password: $('#password').val(),
//            passwordok: $('#password').val(),
            phone: $('#phone').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/users',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('회원이 등록되었습니다.');
            window.location.href='/login';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });

    }

};

main.init();