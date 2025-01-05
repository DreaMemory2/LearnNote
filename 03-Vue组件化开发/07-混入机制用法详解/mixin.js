export const MethodMixin = {
  methods : {
    getInfo() {
      let name = this.name;
      let age = this.age;
      let vip = this.vip;
      if (vip != undefined)
        console.log(name, age, vip);
      if (vip == undefined)
        console.log(name, age);
    }
  }
};
export const getVipMixin = {
  methods : {
    getVip() {
      console.log('Vip Commont');
    }
  }
}
export const MountsMixin = {
  mounted() {
    console.log('User Mount');
  }
}