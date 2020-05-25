var main ={
    init : function(){
        var _this = this;
        $('#regist').on('click',function(){
            _this.regist();
        });

        $('#btn-buy').on('click',function(){
            _this.buy();
        });

    },
    regist : function(){
        var data = {
            name: $('#name').val(),
            category: $('#category').val(),
            price: $('#price').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('상품이 등록되었습니다.');
            window.location.href='/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });

    },
        buy : function(){
            var data = {
                name: $('#name').val(),
                category: $('#category').val(),
                price: $('#price').val(),
                content: $('#content').val()
            };

            var id = $('#id').val();

            $.ajax({
                type: 'PUT',
                url: '/api/v1/posts/'+id,
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function(){
                sell.val() = true;
                alert('상품이 구매되었습니다.');
                window.location.href='/';
            }).fail(function(error){
                alert(JSON.stringify(error));
            });

        }

};

main.init();