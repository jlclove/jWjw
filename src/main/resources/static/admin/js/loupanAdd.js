/**
 * Created by charles on 17/6/7.
 */
var loupanAdd = new Vue({
    el: '#loupan-add-page',
    data: {
        loupan: {},
        loupanList: [],
        config: {},
        provinces: [],
        districts: [],
        showSuccess: false
    },
    created: function () {
        var that = this;

        $.get('/api/loupan', function(data){
            that.loupanList = data;
        });

        $.get('/config', function(data){
            that.config = data;
        })
        $.get('/config/province', function(data){
            var list = [];
            for(var k in data) {
                list.push({text: data[k], value: k})
            }
            that.provinces = list;
            if(list.length > 0) {
                $.get('/config/district?id=' + list[0].value, function(data){
                    try {
                        that.districts = JSON.parse(data).result[0];
                        console.log(that.districts);
                    } catch(e){

                    }
                })
            }
        })
    },
    computed: {
    },
    methods: {
        submit: function(e){

            if(this.loupan.statFunctions) {
                this.loupan.statFunctions = this.loupan.statFunctions.join(",");
            }
            if(this.loupan.structFunctions) {
                this.loupan.structFunctions = this.loupan.structFunctions.join(",");
            }
            if(this.loupan.ageLimits) {
                this.loupan.ageLimits = this.loupan.ageLimits.join(",");
            }
            if(this.loupan.decoItems) {
                this.loupan.decoItems = this.loupan.decoItems.join(",");
            }
            if(this.loupan.layouts) {
                this.loupan.layouts = this.loupan.layouts.join(",");
            }
            var that = this;
            $.ajax({
                type: 'post',
                url: '/admin/loupan',
                data: this.loupan,
                success: function(res) {
                    that.showSuccess = true;
                    setTimeout(function(){
                        window.location.href = "/admin/loupans"
                    }, 3000);
                },
                failure: function(res) {
                    that.showSuccess = false;
                }
            });
        },
        onPropChange: function(evt, item, key){
            this.loupan[key] = this.loupan[key] || [];
            var checked = evt.currentTarget.checked;
            var idx = this.loupan[key].indexOf(item.value)
            if(checked && idx < 0) {
                this.loupan[key].push(item.value);
            }

            if(!checked && idx >= 0) {
                this.loupan[key].splice(idx, 1);
            }
            console.log(this.loupan);
        },
        loadData: function(){
            var that = this;
            $.get('/api/loupan', function(data){
                that.loupanList = data;
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
});