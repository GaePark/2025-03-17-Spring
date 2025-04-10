const app=Vue.createApp({
		data(){
			return{
				curpage:1,
				list:[],
				totalpage:0,
				startPage:0,
				endPage:0,
				type:"한식"
			}
		},
		mounted(){
			this.dataRecv()
		},
		methods:{
			food(type){
				console.log(type)
				this.type=type
				this.curpage=1
				this.dataRecv()
			},
			dataRecv(){
				axios.get("http://localhost:8080/web/food/list_vue.do",{
					params:{
						page:this.curpage,
						type:this.type
					}
				})
				.then(res => {
					console.log(res.data)
					this.list=res.data.list
					this.totalpage=res.data.totalpage
					this.startPage=res.data.startPage
					this.endPage=res.data.endPage
					
				})
				.catch(err => {
					console.log(err.response)
				})
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
		
	}).mount(".container")