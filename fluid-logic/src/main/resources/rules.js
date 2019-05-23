var obj = new Object();

obj.validatePermission = function(user) {
    if(user.profile === 'admin') {
        return true;
    } else {
        return false;
    }
}