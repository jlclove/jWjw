/**
 * Created by charles on 17/6/7.
 */
new Vue({
    el: '#user-list-page',
    data: {
        pagination: {},
        user: {
            admin: false
        },
        error: {}
    },
    created: function () {
        var that = this;

        $('#addUser').on('shown.bs.modal', function () {
            $('#addUser form').reset();
        })

        this.loadData();
    },
    computed: {
    },
    methods: {
        loadData: function(pageNo){
            var that = this;
            pageNo = pageNo || 1;
            $.get('/admin/user?pageNo=' + pageNo, function(data){
                that.pagination = data;
            })
        },
        loadNext: function(){
            console.log(this)
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
        },
        saveUser: function(){
            $.ajax({
                url: '/admin/user',
                type: 'post',
                data: this.user,
                success: function(){
                    window.location = '/admin/users';
                },
                error: function(res){
                    console.log(res);
                    if(res.responseJSON) {
                        alert(res.responseJSON.message);
                    }
                }
            })
        },
        deleteUser: function(id){
            if(confirm("是否删除此用户?")){
                $.ajax({
                    url: '/admin/user/' + id,
                    type: 'delete',
                    success: function(){
                        window.location = '/admin/users'
                    }
                })
            }
        }
    },
    filters: {
        date: function (input) {
            var d = new Date(input);
            var year = d.getFullYear();
            var month = d.getMonth() + 1;
            var day = d.getDate() <10 ? '0' + d.getDate() : '' + d.getDate();
            var hour = d.getHours();
            var minutes = d.getMinutes();
            var seconds = d.getSeconds();
            return  year+ '-' + month + '-' + day + ' ' + hour + ':' + minutes + ':' + seconds;
        }
    }
})