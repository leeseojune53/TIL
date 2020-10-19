$('#hi').on('click', function(){
    $('#hi').animate({marginLeft: '100px', marginTop:'100px'}, 2000)
}); 


var toggle = false;
$('#show-menu').on('click', function(){
    toggle = !toggle;
    if(toggle){
        $('.left-menu').animate({marginLeft: '0px'});
    }else $('.left-menu').animate({marginLeft: '-150px'});
    
});

$('#slide1').on('click', function(){
    $('.slide-container').css('transform', 'translateX(0vw)');
});
$('#slide2').on('click', function(){
    $('.slide-container').css('transform', 'translateX(-100vw)');
});
$('#slide3').on('click', function(){
    $('.slide-container').css('transform', 'translateX(-200vw)');
});