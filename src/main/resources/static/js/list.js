/**
 * Created by charles on 17/5/7.
 */
var app = new Vue({
    el: '#list-page',
    data: {
        filterTabIdx: 0,
        showFilterPanel: false,
        showCityPanel: false,
        items: [],
        layoutType: [],
        orderType: [],
        filterParams: {},
        districts: [],
        provinces: []
    },
    created: function () {
        var that = this;

        $.get('/config', function(data){
            that.layoutType = data.layoutType;
            that.orderType = data.orderType;
        })

        this.loadProvinces(function(){
            that.loadData()
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
            this.filterParams.districtName = v;
            this.showFilterPanel = false;
            this.loadData();
        },
        onChooseHuxin: function(v){
            this.filterParams.layouts = v;
            this.showFilterPanel = false;
            this.loadData();
        },
        onChooseSort: function(v){
            this.filterParams.order = v;
            this.showFilterPanel = false;
            this.loadData();
        },
        onChooseCity: function(v){
            this.filterParams.cityName = v.text;
            this.showCityPanel = false;
            this.filterParams.districtName = '';
            this.loadDistricts(v.id);
            this.loadData();
        },
        loadData: function(){
            var that = this;
            $.get('/api/loupan', this.buildParams({
                name: this.filterParams.name,
                cityName: this.filterParams.cityName,
                districtName: this.filterParams.districtName,
                layouts: this.filterParams.layouts,
                order: this.filterParams.order
            }), function(data){
                that.items = data;
            })
        },
        loadProvinces: function(cb){
            var that = this;
            $.get('/config/province', function(data){
                var provinces = [];
                for(var k in data) {
                    provinces.push({id: k, text: data[k]});
                }
                that.provinces = provinces;

                var province;
                if(!localStorage.province) {
                    province = provinces[0];
                    localStorage.province = JSON.stringify(province);
                } else {
                    province = JSON.parse(localStorage.province);
                }
                that.filterParams.cityName = province.text;

                $.get('/config/district', {id: province.id}, function(data){
                    data = JSON.parse(data);
                    that.districts = data.result[0];
                })
                cb && cb();
            })
        },
        loadDistricts: function(pid, cb){
            var that = this;
            $.get('/config/district', {id: pid}, function(data){
                data = JSON.parse(data);
                that.districts = data.result[0];
                cb && cb();
            })
        },
        buildParams: function(params){
            for(var k in params) {
                if(!params[k]) {
                    delete params[k];
                }
            }
            return params;
        }
    }
})