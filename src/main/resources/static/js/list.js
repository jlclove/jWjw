/**
 * Created by charles on 17/5/7.
 */
var app = new Vue({
    el: '#list-page',
    data: {
        filterTabIdx: 0,
        showFilterPanel: false,
        items: [
            // {
            //     name: '中福浦江汇',
            //     imageUrl: './img/loupan.jpg',
            //     avgPrice: '16000',
            //     address: '黄埔-海潮路133弄（近中山南路）',
            //     layout: [1,2,3]
            // }, {
            //     name: '中福浦江汇',
            //     imageUrl: './img/loupan.jpg',
            //     avgPrice: '16000',
            //     address: '黄埔-海潮路133弄（近中山南路）',
            //     layout: [1,2,3]
            // }, {
            //     name: '中福浦江汇',
            //     imageUrl: './img/loupan.jpg',
            //     avgPrice: '16000',
            //     address: '黄埔-海潮路133弄（近中山南路）',
            //     layout: [1,2,3]
            // }, {
            //     name: '中福浦江汇',
            //     imageUrl: './img/loupan.jpg',
            //     avgPrice: '16000',
            //     address: '黄埔-海潮路133弄（近中山南路）',
            //     layout: [1,2,3]
            // }
        ],
        districts: [{text: "不限", value: ""}, {text: "浦东", value: "浦东"}, {text: "嘉定", value: "嘉定"}, {text: "宝山", value: "宝山"}, {text: "闵行", value: "闵行"}, {text: "青浦", value: "青浦"}, {text: "松江", value: "松江"}, {text: "普陀", value: "普陀"}, {text: "徐汇", value: "徐汇"}, {text: "杨浦", value: "杨浦"}, {text: "虹口", value: "虹口"}, {text: "闸北", value: "闸北"}, {text: "奉贤", value: "奉贤"}, {text: "金山", value: "金山"}, {text: "黄浦", value: "黄浦"}, {text: "静安", value: "静安"}, {text: "卢湾", value: "卢湾"}, {text: "崇明", value: "崇明"}, {text: "长宁", value: "长宁"}, {text: "其他", value: "其他"}, {text: "昆山", value: "昆山"}, {text: "吴江", value: "吴江"}, {text: "嘉兴", value: "嘉兴"}],
        huxins: [{text: "不限", value: ""}, {text: "一居", value: "一居"}, {text: "两居", value: "两居"}, {text: "三居", value: "三居"}, {text: "四居", value: "四居"}, {text: "五居", value: "五居"}, {text: "五居以上", value: "五居以上"}],
        sorts: [{text: "默认", value: ""}, {text: "价格由低到高", value: "价格由低到高"}, {text: "价格由高到低", value: "价格由高到低"}, {text: "开盘时间顺序", value: "开盘时间顺序"}, {text: "开盘时间倒序", value: "开盘时间倒序"}],
        filterParams: {
            keyword: "",
            district: "",
            huxin: "",
            sort: ""
        }
    },
    created: function () {
        var that = this;
        $.get('/api/loupan', function(data){
            that.items = data;
        })
    },
    computed: {
        mergeArray: function(){
            return function (array, suffix, sp) {
                if(!array) {
                    return "";
                }
                return array.map(function(a){
                    return a + suffix
                }).join(sp)
            }

        }
    },
    methods: {
        onBackdropClick: function(e){
            console.log(e)
        },
        onChooseDistrict: function(v){
            this.filterParams.district = v;
            this.showFilterPanel = false;
            this.loadData();
        },
        onChooseHuxin: function(v){
            this.filterParams.huxin = v;
            this.showFilterPanel = false;
            this.loadData();
        },
        onChooseSort: function(v){
            this.filterParams.sort = v;
            this.showFilterPanel = false;
            this.loadData();
        },
        loadData: function(){
            console.log(JSON.stringify(this.filterParams));
        }
    }
})