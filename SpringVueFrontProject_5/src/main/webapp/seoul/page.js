const listapp = Vue.createApp({
			data(){
				return{
						list:[],
						curpage:1,
						totalpage:0,
						startPage:0,
						endPage:0,
						type:1,
						title:"서울 명소"
				}
			},
			mounted(){
				this.dataRecv()
			},
			//updated
			//Vue의 멤버함수
			methods:{
				dataRecv(){
					axios.get("../seoul/list_vue.do",{
							params:{
						type:this.type,
						page:this.curpage
							}
						})
						.then(res => {
							console.log(res)
							this.list=res.data.list
							this.totalpage=res.data.totalpage
							this.startPage=res.data.startPage
							this.endPage=res.data.endPage
							this.title=res.data.title
						})
						.catch(err => {
							console.log(err)
						})
				},
				seoul(type){
					this.type=type
					this.curpage=1
					this.dataRecv()
				},
				range(start,end){
					let arr=[]
					let len=end-start
					for(let i=0;i<=len;i++)
					{
						arr[i]=start
						start++
					}
					return arr
				},
				next(){
					this.curpage=this.endPage+1
					this.dataRecv()
				},
				prev(){
					this.curpage=this.startPage-1
					this.dataRecv()
				},
				pageChange(i){
					this.curpage=i
					this.dataRecv()
				}
				
			}
			//watch / computed / component
		}).mount(".container")