<template>
    <div>
        <label for="text">text</label>
        <input id="text" type="text" v-model="str" />
        <br />
        <label for="integer1">integer1</label>
        <input id="integer1" type="number" v-model="integer1" />
        <br />
        <label for="integer2">integer2</label>
        <input id="integer2" type="number" v-model="integer2" />
        <br />
        <button @click="passGet">get</button>
        <button @click="passPost">post</button>

        <br />
        <br />
        <div>
            <label for="newText">text</label>
            <input id="newText" type="text" v-model="newStr" />
            <br />
            <label for="sum">sum</label>
            <input id="sum" type="text" v-model="sum" />
        </div>
    </div>
</template>

<script>
import axios from "axios";
export default {
    data() {
        return {
            str: " ",
            integer1: null,
            integer2: null,
            sum: null,
            newStr: "",
        };
    },
    methods: {
        passGet() {
            axios
                .get("/api/get")
                .then(function (response) {
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        passPost() {
            axios
                .post("/api/post", [this.str, this.integer1, this.integer2])
                .then((res) => {
                    const newAry = res.data.split(",");
                    this.sum = newAry[1];
                    this.newStr = newAry[0];

                    console.log(newAry);
                })
                .catch((err) => {
                    console.log(err);
                });
        },
    },
};
</script>

<style></style>
