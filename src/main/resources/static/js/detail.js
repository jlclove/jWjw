/**
 * Created by charles on 17/5/7.
 */
var app = new Vue({
    el: '#detail-page',
    data: {
        loupan: {},
        layoutTypeList: [],
        statFunctionList: [],
        structFunctionList: [],
        flagList: [],
        ageLimitList: [],
        decoItemList: [],
        imageList: [],
        allImages: {},
        config: {}
    },
    created: function () {
        var params = window.location.pathname.match(/\/page\/loupan\/(\d+)/);
        // 图片什么的已经都在了
        if(params) {
            var that = this;
            $.get('/api/loupan/' + params[1], function(data){
                that.loupan = data.loupan;
                that.layoutTypeList = data.layoutTypeList;
                that.statFunctionList = data.statFunctionList;
                that.structFunctionList = data.structFunctionList;
                that.flagList = data.flagList;
                that.ageLimitList = data.ageLimitList;
                that.decoItemList = data.decoItemList;
                var imgs = [];
                for(var k in data.picMap){
                    for(var j = 0; j < data.picMap[k].length; j++){
                        data.picMap[k][j].src = '/imgs/'+data.picMap[k][j].picUrl;
                        data.picMap[k][j].w = 600;
                        data.picMap[k][j].h = 400;
                    }
                    imgs.push(data.picMap[k]);
                }
                that.allImages = imgs;
                that.imageList = that.allImages[0];
                setTimeout(function(){
                    initSwiper();
                }, 60);
            })
        }
        $.get('/config', function(data){
            that.config = data;
        })
    },
    computed: {},
    methods: {
        switchImgCate: function(type){
            this.imageList = this.allImages[type];
            setTimeout(function(){
                initSwiper();
            }, 60);
        },
        back: function(){
            window.history.back();
        },
        onClick: function () {
            initPhotoSwiper(this.imageList);
        }
    },
    mounted: function(){
        // initSwiper();
    }
})

function initSwiper() {
    var mySwiper = new Swiper('.swiper-container', {
        loop: true,

        // 如果需要分页器
        pagination: '.swiper-pagination',
        paginationType: 'fraction',

        // 如果需要前进后退按钮
        // nextButton: '.swiper-button-next',
        // prevButton: '.swiper-button-prev',

        // 如果需要滚动条
        // scrollbar: '.swiper-scrollbar',
    })
}

function initPhotoSwiper(items) {
    var pswpElement = document.querySelectorAll('.pswp')[0];

// build items array
//     var items = [
//         {
//             src: 'https://placekitten.com/600/400',
//             w: 600,
//             h: 400
//         },
//         {
//             src: 'https://placekitten.com/1200/900',
//             w: 1200,
//             h: 900
//         }
//     ];

// define options (if needed)
    var options = {
        // optionName: 'option value'
        // for example:
        index: 0, // start at first slide
        shareEl: false,
        fullscreenEl: false
    };

// Initializes and opens PhotoSwipe
    var gallery = new PhotoSwipe(pswpElement, PhotoSwipeUI_Default, items, options);
    gallery.init();
}

