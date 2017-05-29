/**
 * Created by charles on 17/5/7.
 */
var app = new Vue({
    el: '#detail-page',
    data: {
        imageList: [
            {
                src: 'img/f1.jpg',
                w: 600,
                h: 400
            },
            {
                src: 'img/f2.jpg',
                w: 600,
                h: 400
            },
            {
                src: 'img/f2.jpg',
                w: 600,
                h: 400
            }
        ]
    },
    computed: {},
    methods: {
        back: function(){
            window.history.back();
        },
        onClick: function () {
            initPhotoSwiper(this.imageList);
        }
    },
    mounted: function(){
        initSwiper();
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

