$('#approve').on('click', function () {
    if(confirm('Are you sure that you want to approve this application?')) {

    } else {

    }
});

$('#reject').on('click', function () {
    if(confirm('Are you sure that you want to approve this application?')) {

    } else {

    }
});

function app() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http:http://localhost:8080/applications/1",
        // success: function(data){
        //     alert(data);
        //     $.each(data, function(index, data) {
        //
        //         var foo = $.extend(new Foo(result[key].name));
        //         users.push(foo );
        //
        //     });
        //
        // }
    });
}