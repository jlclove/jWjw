/**
 * Created by charles on 17/6/7.
 */
new Vue({
    el: '#loupan-list-page',
    data: {
        pagination: {}
    },
    created: function () {
        var that = this;

        this.loadData();
    },
    computed: {
    },
    methods: {
        loadData: function(pageNo){
            var that = this;
            pageNo = pageNo || 1;
            $.get('/api/loupanPage?pageNo=' + pageNo, function(data){
                that.pagination = data;
            })
        },
        loadNext: function(){
            this.loadData(this.pagination.pageNo + 1);
        },
        loadPrev: function(){
            this.loadData(this.pagination.pageNo - 1);
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