/**
 * Created by charles on 17/6/7.
 */
var loupanAdd = new Vue({
    el: '#loupan-edit-page',
    data: {
        loupan: {},
        config: {},
        picList: [],
        provinces: [],
        districts: [],
        showSuccess: false
    },
    created: function () {
        var that = this;

        $.get('/config', function(data){
            that.config = data;
            setTimeout(function(){
                that.initEvent();
            }, 100);
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
                    } catch(e){

                    }
                })
            }
        })
        this.loupan = loupan.loupan;
        console.log(loupan);
    },
    mounted: function(){
        var that = this;
        $("#addForm").validate({
            messages: {
                name: "必填",
                cityName: "必填",
                districtName: "必填",
                linkerPhone: "必填",
                avgPrice: "不合法的值"
            },
            submitHandler: function(form) {
                that.submit();
            }
        });
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
        savePic: function(){
            var that = this;
            $.ajax({
                type: 'post',
                url: '/admin/loupan/pic',
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
        buildParams: function(params){
            for(var k in params) {
                if(!params[k]) {
                    delete params[k];
                }
            }
            return params;
        },
        initEvent: function(){
            var that = this;
            var deleteButton = $('<a/>')
                .addClass('btn btn-danger btn-sm')
                .prop('disabled', true)
                .text('删除')
                .on('click', function (e) {
                    var $this = $(this),
                        data = $this.data();
                    data.context.remove();
                    var img = data.response().result;
                    var idx;
                    that.picList.find(function(item, i){
                        if(item.picUrl == img){
                            idx = i;
                            return true;
                        }
                    });
                    if(idx >= 0) {
                        that.picList.splice(idx, 1);
                    }
                    console.log(that.picList);
                    // updateFormData();
                });
            $('input[type=file]').fileupload({
                paramName: 'file',
                url: '/admin/loupan/pic/upload',
                autoUpload: true,
                acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
                disableImageResize: /Android(?!.*Chrome)|Opera/
                    .test(window.navigator.userAgent),
                previewMaxWidth: 100,
                previewMaxHeight: 100,
                previewCrop: true
            })
            .on('fileuploadadd', function (e, data) {
                var fileWrap = $(e.target).closest('.form-group').find('.files');
                data.context = $('<div style="display: inline-block;width: 110px;height: 150px;vertical-align: top"/>').appendTo(fileWrap);
                $.each(data.files, function (index, file) {
                    var node = $('<p/>');
                    if (!index) {
                        node.append(deleteButton.clone(true).data(data));
                    }
                    node.appendTo(data.context);
                });
            })
            .on('fileuploadprocessalways', function (e, data) {
                var index = data.index,
                    file = data.files[index],
                    node = $(data.context.children()[index]);
                if (file.preview) {
                    node.prepend(file.preview);
                }
                if (file.error) {
                    node.append($('<span class="text-danger"/>').text(file.error));
                }
            })
            .on('fileuploaddone', function (e, data) {
                var file = data.result;

                if (file) {
                    var link = $('<a>')
                        .attr('target', '_blank')
                        .css('display', 'block')
                        .prop('href', '/imgs/' + file);
                    $($(data.context.children()[0]).children()[0]).wrap(link);
                    that.picList.push({
                        type: $(this).data('type'),
                        picUrl: file
                    })
                    // updateFormData();
                } else if (file.error) {
                    var error = $('<span class="text-danger"/>').text(file.error);
                    $(data.context.children()[0])
                        .append('<br>')
                        .append(error);
                }
            }).on('fileuploadfail', function (e, data) {
                $.each(data.files, function (index) {
                    var error = $('<span class="text-danger"/>').text('上传失败.');
                    $(data.context.children()[index])
                        .append('<br>')
                        .append(error);
                });
            }).prop('disabled', !$.support.fileInput)
                .parent().addClass($.support.fileInput ? undefined : 'disabled');


        }
    }
});