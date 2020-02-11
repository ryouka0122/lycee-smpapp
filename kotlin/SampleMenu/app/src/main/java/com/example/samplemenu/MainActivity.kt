package com.example.samplemenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.SimpleAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var _menuList : MutableList<MutableMap<String, Any>>? = null

    val FROM = arrayOf("name", "price")
    val TO = intArrayOf(R.id.tvMenuName, R.id.tvMenuPrice)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _menuList = createTeishokuList()

        val adapter = SimpleAdapter(applicationContext, _menuList, R.layout.row, FROM, TO)

        lvMenu.adapter = adapter
        lvMenu.onItemClickListener = ListItemClickListener()

        registerForContextMenu(lvMenu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options_menu_list, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.menuListOptionSetPlate -> _menuList = createTeishokuList()
            R.id.menuListOptionCurry -> _menuList = createCurryList()
        }
        val adapter = SimpleAdapter(applicationContext, _menuList, R.layout.row, FROM, TO)

        lvMenu.adapter = adapter
        lvMenu.onItemClickListener = ListItemClickListener()

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.menu_context_menu_list, menu)
        menu.setHeaderTitle(R.string.menu_list_context_header)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val listPosition = info.position
        val menu = _menuList!![listPosition]

        when(item.itemId) {
            R.id.menuListContextDesc -> {
                val desc = menu["desc"] as String
                Toast.makeText(applicationContext, desc, Toast.LENGTH_SHORT).show()
            }
            R.id.menuListContextOrder ->
                order(menu)
        }
        
        return super.onContextItemSelected(item)
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
            val item = parent.getItemAtPosition(position) as MutableMap<String, Any>

            order(item)
        }
    }

    private fun order(item : MutableMap<String, Any>) {

        val name = item["name"] as String
        val price = item["price"] as Int

        val intent = Intent(applicationContext, MenuThanksActivity::class.java)

        intent.putExtra("menuName", name)
        intent.putExtra("menuPrice", "${price}円")

        startActivity(intent)
    }

    private fun createTeishokuList() : MutableList<MutableMap<String, Any>> {
        val menuList: MutableList<MutableMap<String, Any>> = mutableListOf()
        menuList.add(mutableMapOf("name" to "唐揚げ定食", "price" to 800, "desc" to "唐揚げ定食です．"))
        menuList.add(mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "ハンバーグ定食です．"))
        menuList.add(mutableMapOf("name" to "生姜焼き定食", "price" to 850, "desc" to "生姜焼き定食です．"))
        menuList.add(mutableMapOf("name" to "ステーキ定食", "price" to 1000, "desc" to "ステーキ定食です．"))
        menuList.add(mutableMapOf("name" to "野菜炒め定食", "price" to 750, "desc" to "野菜炒め定食です．"))
        menuList.add(mutableMapOf("name" to "とんかつ定食", "price" to 900, "desc" to "とんかつ定食です．"))
        menuList.add(mutableMapOf("name" to "ミンチかつ定食", "price" to 850, "desc" to "ミンチかつ定食です．"))
        menuList.add(mutableMapOf("name" to "チキンカツ定食", "price" to 900, "desc" to "チキンカツ定食です．"))
        menuList.add(mutableMapOf("name" to "コロッケ定食", "price" to 850, "desc" to "コロッケ定食です．"))
        menuList.add(mutableMapOf("name" to "焼き魚定食", "price" to 700, "desc" to "焼き魚定食です．"))
        menuList.add(mutableMapOf("name" to "焼肉定食", "price" to 850, "desc" to "焼肉定食です．"))
        return menuList
    }

    private fun createCurryList() : MutableList<MutableMap<String, Any>> {
        val menuList: MutableList<MutableMap<String, Any>> = mutableListOf()
        menuList.add(mutableMapOf("name" to "ビーフカレー", "price" to 520, "desc" to "ビーフカレーです．"))
        menuList.add(mutableMapOf("name" to "ポークカレー", "price" to 420, "desc" to "ポークカレーです．"))
        menuList.add(mutableMapOf("name" to "ハンバーグカレー", "price" to 620, "desc" to "ハンバーグカレーです．"))
        menuList.add(mutableMapOf("name" to "チーズカレー", "price" to 560, "desc" to "チーズカレーです．"))
        menuList.add(mutableMapOf("name" to "カツカレー", "price" to 760, "desc" to "カツカレーです．"))
        menuList.add(mutableMapOf("name" to "ビーフカツカレー", "price" to 660, "desc" to "ビーフカツカレーです．"))
        menuList.add(mutableMapOf("name" to "唐揚げカレー", "price" to 540, "desc" to "唐揚げカレーです．"))
        return menuList
    }
}
