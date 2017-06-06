/**
 * Created by charles on 17/6/7.
 */
new Vue({
    el: '#loupan-list-page',
    data: {
        loupanList: []
    },
    created: function () {
        var that = this;

        $.get('/api/loupan', function(data){
            that.loupanList = data;
        })
    },
    computed: {
    },
    methods: {
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
})