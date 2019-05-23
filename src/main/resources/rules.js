var obj = new Object();

obj.validatePermission = function(user) {
    console.log(user.profile)
    if(user.profile === 'admin') {
        return true;
    } else {
        throw 'Unauthorized. User must be administrator.';
    }
}