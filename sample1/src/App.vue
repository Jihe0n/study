<template>
    <div>
        <div style="text-align: center">
            <div class="mt-2">
                <label for="text">문자</label>
                <input
                    class="m-1"
                    id="text"
                    type="text"
                    v-model="formData.text"
                />
            </div>
            <div>
                <label for="int1">숫자1</label>
                <input
                    class="m-1"
                    id="int1"
                    type="number"
                    v-model="formData.int1"
                />
            </div>
            <div>
                <label for="int2">숫자2</label>
                <input
                    class="m-1"
                    id="int2"
                    type="number"
                    v-model="formData.int2"
                />
            </div>
            <div class="mb-2">
                <label for="sum">합계</label>
                <input
                    class="m-1"
                    id="sum"
                    type="number"
                    v-model="sum"
                    readonly
                />
            </div>

            <button type="button" class="btn btn-primary m-2" @click="sumGet">
                GET
            </button>
            <button type="button" class="btn btn-primary m-2" @click="sumPost">
                POST
            </button>
        </div>

        <hr />
        <div id="select">
            <select
                name="combo"
                id="combo"
                class="form-select form-select-lg m-2"
                aria-label="Default select example"
                style="width: 8rem"
            >
                <option value="none">선택</option>
                <option value="title">제목</option>
                <option value="contents">내용</option>
            </select>

            <div class="input-group m-2" style="width: 400px">
                <input
                    v-model="selectformData.inputValue"
                    type="text"
                    class="form-control"
                    aria-label="Recipient's username"
                    aria-describedby="button-addon2"
                />
                <button
                    @click="searchPost"
                    class="btn btn-outline-secondary"
                    type="button"
                    id="button-addon2"
                >
                    Post
                </button>
                <button
                    @click="searchGet"
                    class="btn btn-outline-secondary"
                    type="button"
                    id="button-addon2"
                >
                    Get
                </button>
            </div>
        </div>

        <table class="table mt-2">
            <thead>
                <tr>
                    <th scope="col">번호</th>
                    <th scope="col">제목</th>
                    <th scope="col">내용</th>
                    <th scope="col">작성자</th>
                    <th scope="col">작성일시</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="value in returnArray" :key="value.boardId">
                    <th scope="row">{{ value.boardId }}</th>
                    <td>{{ value.title }}</td>
                    <td>{{ value.contents }}</td>
                    <td>
                        {{ value.userNm }} <br />
                        ({{ value.createId }})
                    </td>
                    <td>{{ dateCal(value.createDtime).toLocaleString() }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import axios from "axios";
export default {
    data() {
        return {
            formData: {
                text: null,
                int1: null,
                int2: null,
            },
            sum: null,

            selectformData: {
                selectOption: null,
                inputValue: null,
            },
            returnArray: [],
        };
    },
    methods: {
        searchPost() {
            var elment = document.getElementById("combo");
            var selectInex =
                document.getElementById("combo").options.selectedIndex;
            this.selectformData.selectOption = elment.options[selectInex].value;

            console.log(this.selectformData);

            axios
                .post("/api/boardPost", this.selectformData)
                .then((res) => {
                    console.log(res);
                    this.returnArray = res.data;
                })
                .catch((err) => {
                    console.log(err);
                });
        },
        searchGet() {
            var elment = document.getElementById("combo");
            var selectInex =
                document.getElementById("combo").options.selectedIndex;
            this.selectformData.selectOption = elment.options[selectInex].value;

            console.log(this.selectformData);

            axios
                .get("/api/boardGet", {
                    params: {
                        selectOption: this.selectformData.selectOption,
                        inputValue: this.selectformData.inputValue,
                    },
                })
                .then((res) => {
                    console.log(res);
                    this.returnArray = res.data;
                })
                .catch((err) => {
                    console.log(err);
                });
        },

        sumGet() {
            axios
                .get("/api/get", {
                    params: {
                        // config
                        text: this.formData.text,
                        int1: this.formData.int1,
                        int2: this.formData.int2,
                    },
                })
                .then((res) => {
                    console.log(res);
                    this.sum = res.data;
                })
                .catch((err) => {
                    console.log(err);
                });
        },

        sumPost() {
            axios
                .post("/api/post", this.formData)
                .then((res) => {
                    this.sum = res.data;
                    console.log(res);
                })
                .catch((err) => {
                    console.log(err);
                });
        },

        dateCal(date) {
            //20220311150717
            let yyyy = date.substr(0, 4); // 2022
            let mm = date.substr(4, 2); // 03
            let dd = date.substr(6, 2); // 11
            let hh = date.substr(8, 2); // 15
            let mi = date.substr(10, 2); // 07
            let ss = date.substr(12, 2); // 17
            return new Date(yyyy, mm, dd, hh, mi, ss);
        },
    },
};
</script>

<style scoped>
#select {
    display: flex;
}

tr {
    text-align: center;
}
</style>
