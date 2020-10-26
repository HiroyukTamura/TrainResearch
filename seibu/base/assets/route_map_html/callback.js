$(document).ready(function(){
    $("area").off('click').on('click', function(){
        JavaScriptInterface.station($(this).prop('alt'));
    });
})