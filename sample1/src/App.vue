<template>
    <div>
        <select
            name="combo"
            id="combo"
            class="form-select form-select-lg m-2"
            aria-label="Default select example"
            style="width: 400px"
        >
            <option value="none">선택</option>
            <option value="title">제목</option>
            <option value="contents">내용</option>
        </select>

        <div class="input-group m-2" style="width: 400px">
            <input
                v-model="inputValue"
                @keyup.enter="search"
                type="text"
                class="form-control"
                aria-label="Recipient's username"
                aria-describedby="button-addon2"
            />
            <button
                @click="search"
                class="btn btn-outline-secondary"
                type="button"
                id="button-addon2"
            >
                Search
            </button>
        </div>

        <table class="table mt-5">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">제목</th>
                    <th scope="col">내용</th>
                    <th scope="col">작성자</th>
                    <th scope="col">작성일시</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                    <td>@fat</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td colspan="2">Larry the Bird</td>
                    <td>@twitter</td>
                    <td>@twitter</td>
                </tr>
            </tbody>
        </table>
        {{ returnobj }}
    </div>
</template>

<script>
import axios from "axios";
export default {
    data() {
        return {
            selectOption: null,
            inputValue: null,
            returnobj: {},
        };
    },
    methods: {
        search() {
            var elment = document.getElementById("combo");
            var selectInex =
                document.getElementById("combo").options.selectedIndex;
            this.selectOption = elment.options[selectInex].value;

            const formData = {
                selectOption: this.selectOption,
                inputValue: this.inputValue,
            };
            console.log(formData);

            axios
                .post("/api/test", formData)
                .then((res) => {
                    console.log(res.data);
                    this.returnobj = res.data;
                })
                .catch((err) => {
                    console.log(err);
                });
        },
    },
};
</script>

<style scoped>
.inputBox,
button {
    margin-left: 0.3rem;
}
</style>
