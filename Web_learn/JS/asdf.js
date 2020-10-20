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


$('#slide-1').on('click', function(){
    $('.slide-container').css('transform', 'translateX(0vw)');
});
$('#slide-2').on('click', function(){
    $('.slide-container').css('transform', 'translateX(-100vw)');
});
$('#slide-3').on('click', function(){
    $('.slide-container').css('transform', 'translateX(-200vw)');
});

var show = 1;
$('.slide-next').on('click', function(){
    if(show == 1){
        $('.slide-container').css('transform', 'translateX(-100vw)');
        show = show + 1;
        
        
    }else if(show == 2){
        $('.slide-container').css('transform', 'translateX(-200vw)');
        show = show + 1;
    }
});

$('.slide-before').on('click', function(){
    if(show == 3){
        $('.slide-container').css('transform', 'translateX(-100vw)');
        show = show - 1;
        
    }else if(show == 2){
        $('.slide-container').css('transform', 'translateX(0vw)');
        show = show - 1;
    }
});